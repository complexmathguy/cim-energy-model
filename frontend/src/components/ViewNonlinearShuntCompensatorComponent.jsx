import React, { Component } from 'react'
import NonlinearShuntCompensatorService from '../services/NonlinearShuntCompensatorService'

class ViewNonlinearShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nonlinearShuntCompensator: {}
        }
    }

    componentDidMount(){
        NonlinearShuntCompensatorService.getNonlinearShuntCompensatorById(this.state.id).then( res => {
            this.setState({nonlinearShuntCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View NonlinearShuntCompensator Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewNonlinearShuntCompensatorComponent
