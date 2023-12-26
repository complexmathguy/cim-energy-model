import React, { Component } from 'react'
import PerCentService from '../services/PerCentService'

class ViewPerCentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            perCent: {}
        }
    }

    componentDidMount(){
        PerCentService.getPerCentById(this.state.id).then( res => {
            this.setState({perCent: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PerCent Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.perCent.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.perCent.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.perCent.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPerCentComponent
