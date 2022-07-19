import React, { Component } from "react";
import ModalVideo from "react-modal-video";
import "react-modal-video/css/modal-video.css";


export class VideoModal extends Component {
  
  constructor(video) {
    super();
    this.state = {
      videoId: video,
      isOpen: false,
    };
    this.openModal = this.openModal.bind(this);
  }

  openModal() {
    this.setState({ isOpen: true });
  }
  render() {
    return (
        
      <div>
        <div>
          <ModalVideo
            channel="youtube"
            isOpen={this.state.isOpen}
            videoId= {this.state.videoId}
            onClose={() => this.setState({ isOpen: false })}
          />
          <button onClick={this.openModal}>Open</button>
        </div>
      </div>
    );
  }
}

export default VideoModal;