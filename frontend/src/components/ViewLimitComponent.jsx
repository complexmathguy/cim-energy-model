import React, { Component } from 'react'
import LimitService from '../services/LimitService'

class ViewLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            limit: {}
        }
    }

    componentDidMount(){
        LimitService.getLimitById(this.state.id).then( res => {
            this.setState({limit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Limit Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLimitComponent
