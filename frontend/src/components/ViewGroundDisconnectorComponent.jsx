import React, { Component } from 'react'
import GroundDisconnectorService from '../services/GroundDisconnectorService'

class ViewGroundDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            groundDisconnector: {}
        }
    }

    componentDidMount(){
        GroundDisconnectorService.getGroundDisconnectorById(this.state.id).then( res => {
            this.setState({groundDisconnector: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GroundDisconnector Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGroundDisconnectorComponent
