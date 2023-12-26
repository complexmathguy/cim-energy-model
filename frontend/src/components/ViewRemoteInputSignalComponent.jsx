import React, { Component } from 'react'
import RemoteInputSignalService from '../services/RemoteInputSignalService'

class ViewRemoteInputSignalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            remoteInputSignal: {}
        }
    }

    componentDidMount(){
        RemoteInputSignalService.getRemoteInputSignalById(this.state.id).then( res => {
            this.setState({remoteInputSignal: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RemoteInputSignal Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> remoteSignalType:&emsp; </label>
                            <div> { this.state.remoteInputSignal.remoteSignalType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRemoteInputSignalComponent
