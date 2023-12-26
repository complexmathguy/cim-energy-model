import React, { Component } from 'react'
import DisconnectorService from '../services/DisconnectorService'

class ViewDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            disconnector: {}
        }
    }

    componentDidMount(){
        DisconnectorService.getDisconnectorById(this.state.id).then( res => {
            this.setState({disconnector: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Disconnector Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDisconnectorComponent
