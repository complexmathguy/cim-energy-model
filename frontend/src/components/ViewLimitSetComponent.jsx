import React, { Component } from 'react'
import LimitSetService from '../services/LimitSetService'

class ViewLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            limitSet: {}
        }
    }

    componentDidMount(){
        LimitSetService.getLimitSetById(this.state.id).then( res => {
            this.setState({limitSet: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LimitSet Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> isPercentageLimits:&emsp; </label>
                            <div> { this.state.limitSet.isPercentageLimits }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLimitSetComponent
