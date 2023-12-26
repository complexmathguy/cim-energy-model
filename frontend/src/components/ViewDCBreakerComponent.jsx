import React, { Component } from 'react'
import DCBreakerService from '../services/DCBreakerService'

class ViewDCBreakerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCBreaker: {}
        }
    }

    componentDidMount(){
        DCBreakerService.getDCBreakerById(this.state.id).then( res => {
            this.setState({dCBreaker: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCBreaker Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCBreakerComponent
