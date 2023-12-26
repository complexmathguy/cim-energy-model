import React, { Component } from 'react'
import ProtectedSwitchService from '../services/ProtectedSwitchService'

class ViewProtectedSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            protectedSwitch: {}
        }
    }

    componentDidMount(){
        ProtectedSwitchService.getProtectedSwitchById(this.state.id).then( res => {
            this.setState({protectedSwitch: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ProtectedSwitch Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewProtectedSwitchComponent
