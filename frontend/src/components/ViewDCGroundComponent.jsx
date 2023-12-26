import React, { Component } from 'react'
import DCGroundService from '../services/DCGroundService'

class ViewDCGroundComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCGround: {}
        }
    }

    componentDidMount(){
        DCGroundService.getDCGroundById(this.state.id).then( res => {
            this.setState({dCGround: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCGround Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> inductance:&emsp; </label>
                            <div> { this.state.dCGround.inductance }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.dCGround.r }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCGroundComponent
