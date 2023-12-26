import React, { Component } from 'react'
import DCNodeService from '../services/DCNodeService'

class ViewDCNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCNode: {}
        }
    }

    componentDidMount(){
        DCNodeService.getDCNodeById(this.state.id).then( res => {
            this.setState({dCNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCNode Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCNodeComponent
