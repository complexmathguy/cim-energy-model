import React, { Component } from 'react'
import SynchronousMachineUserDefinedService from '../services/SynchronousMachineUserDefinedService'

class ViewSynchronousMachineUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachineUserDefined: {}
        }
    }

    componentDidMount(){
        SynchronousMachineUserDefinedService.getSynchronousMachineUserDefinedById(this.state.id).then( res => {
            this.setState({synchronousMachineUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachineUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.synchronousMachineUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineUserDefinedComponent
