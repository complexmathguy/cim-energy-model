import React, { Component } from 'react'
import BreakerService from '../services/BreakerService'

class ViewBreakerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            breaker: {}
        }
    }

    componentDidMount(){
        BreakerService.getBreakerById(this.state.id).then( res => {
            this.setState({breaker: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Breaker Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBreakerComponent
