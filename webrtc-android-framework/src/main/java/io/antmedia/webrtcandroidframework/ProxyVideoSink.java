package io.antmedia.webrtcandroidframework;

import org.webrtc.Logging;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

public class ProxyVideoSink implements VideoSink {
    private VideoSink target;
    private String TAG = "ProxyVideoSink";

    @Override
    synchronized public void onFrame(VideoFrame frame) {
      if (target == null) {
        Logging.d(TAG, "Dropping frame in proxy because target is null.");
        return;
      }

      target.onFrame(frame);
    }

    synchronized public void setTarget(VideoSink target) {
      this.target = target;
    }
    synchronized public VideoSink getTarget() {
      return target;
    }
  }