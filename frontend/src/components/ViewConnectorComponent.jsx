import React, { Component } from 'react'
import ConnectorService from '../services/ConnectorService'

class ViewConnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            connector: {}
        }
    }

    componentDidMount(){
        ConnectorService.getConnectorById(this.state.id).then( res => {
            this.setState({connector: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Connector Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConnectorComponent
