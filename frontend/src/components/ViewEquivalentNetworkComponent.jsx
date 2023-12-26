import React, { Component } from 'react'
import EquivalentNetworkService from '../services/EquivalentNetworkService'

class ViewEquivalentNetworkComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equivalentNetwork: {}
        }
    }

    componentDidMount(){
        EquivalentNetworkService.getEquivalentNetworkById(this.state.id).then( res => {
            this.setState({equivalentNetwork: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquivalentNetwork Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquivalentNetworkComponent
