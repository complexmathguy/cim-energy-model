import React, { Component } from 'react'
import ENTSOETopologicalNodeService from '../services/ENTSOETopologicalNodeService'

class ViewENTSOETopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            eNTSOETopologicalNode: {}
        }
    }

    componentDidMount(){
        ENTSOETopologicalNodeService.getENTSOETopologicalNodeById(this.state.id).then( res => {
            this.setState({eNTSOETopologicalNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ENTSOETopologicalNode Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewENTSOETopologicalNodeComponent
