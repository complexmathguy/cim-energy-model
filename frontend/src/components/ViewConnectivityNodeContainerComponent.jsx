import React, { Component } from 'react'
import ConnectivityNodeContainerService from '../services/ConnectivityNodeContainerService'

class ViewConnectivityNodeContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            connectivityNodeContainer: {}
        }
    }

    componentDidMount(){
        ConnectivityNodeContainerService.getConnectivityNodeContainerById(this.state.id).then( res => {
            this.setState({connectivityNodeContainer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ConnectivityNodeContainer Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConnectivityNodeContainerComponent
