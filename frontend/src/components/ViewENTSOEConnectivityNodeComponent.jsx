import React, { Component } from 'react'
import ENTSOEConnectivityNodeService from '../services/ENTSOEConnectivityNodeService'

class ViewENTSOEConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            eNTSOEConnectivityNode: {}
        }
    }

    componentDidMount(){
        ENTSOEConnectivityNodeService.getENTSOEConnectivityNodeById(this.state.id).then( res => {
            this.setState({eNTSOEConnectivityNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ENTSOEConnectivityNode Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewENTSOEConnectivityNodeComponent
