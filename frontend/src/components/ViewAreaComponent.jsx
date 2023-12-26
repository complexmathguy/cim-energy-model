import React, { Component } from 'react'
import AreaService from '../services/AreaService'

class ViewAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            area: {}
        }
    }

    componentDidMount(){
        AreaService.getAreaById(this.state.id).then( res => {
            this.setState({area: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Area Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.area.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.area.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.area.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAreaComponent
