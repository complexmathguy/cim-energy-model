import React, { Component } from 'react'
import TapChangerService from '../services/TapChangerService'

class ViewTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            tapChanger: {}
        }
    }

    componentDidMount(){
        TapChangerService.getTapChangerById(this.state.id).then( res => {
            this.setState({tapChanger: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TapChanger Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> highStep:&emsp; </label>
                            <div> { this.state.tapChanger.highStep }</div>
                        </div>
                        <div className = "row">
                            <label> lowStep:&emsp; </label>
                            <div> { this.state.tapChanger.lowStep }</div>
                        </div>
                        <div className = "row">
                            <label> ltcFlag:&emsp; </label>
                            <div> { this.state.tapChanger.ltcFlag }</div>
                        </div>
                        <div className = "row">
                            <label> neutralStep:&emsp; </label>
                            <div> { this.state.tapChanger.neutralStep }</div>
                        </div>
                        <div className = "row">
                            <label> neutralU:&emsp; </label>
                            <div> { this.state.tapChanger.neutralU }</div>
                        </div>
                        <div className = "row">
                            <label> normalStep:&emsp; </label>
                            <div> { this.state.tapChanger.normalStep }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTapChangerComponent
