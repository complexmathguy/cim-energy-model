import React, { Component } from 'react'
import OperationalLimitService from '../services/OperationalLimitService'

class ViewOperationalLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            operationalLimit: {}
        }
    }

    componentDidMount(){
        OperationalLimitService.getOperationalLimitById(this.state.id).then( res => {
            this.setState({operationalLimit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OperationalLimit Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOperationalLimitComponent
