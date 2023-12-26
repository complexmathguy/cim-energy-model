import React, { Component } from 'react'
import SecondsService from '../services/SecondsService'

class ViewSecondsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            seconds: {}
        }
    }

    componentDidMount(){
        SecondsService.getSecondsById(this.state.id).then( res => {
            this.setState({seconds: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Seconds Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.seconds.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.seconds.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.seconds.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSecondsComponent
