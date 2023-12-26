import React, { Component } from 'react'
import DCTopologicalNodeService from '../services/DCTopologicalNodeService'

class ViewDCTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCTopologicalNode: {}
        }
    }

    componentDidMount(){
        DCTopologicalNodeService.getDCTopologicalNodeById(this.state.id).then( res => {
            this.setState({dCTopologicalNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCTopologicalNode Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCTopologicalNodeComponent
