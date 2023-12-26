import React, { Component } from 'react'
import SvStatusService from '../services/SvStatusService'

class ViewSvStatusComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            svStatus: {}
        }
    }

    componentDidMount(){
        SvStatusService.getSvStatusById(this.state.id).then( res => {
            this.setState({svStatus: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SvStatus Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> inService:&emsp; </label>
                            <div> { this.state.svStatus.inService }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSvStatusComponent
