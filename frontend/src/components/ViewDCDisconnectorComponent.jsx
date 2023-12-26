import React, { Component } from 'react'
import DCDisconnectorService from '../services/DCDisconnectorService'

class ViewDCDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCDisconnector: {}
        }
    }

    componentDidMount(){
        DCDisconnectorService.getDCDisconnectorById(this.state.id).then( res => {
            this.setState({dCDisconnector: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCDisconnector Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCDisconnectorComponent
