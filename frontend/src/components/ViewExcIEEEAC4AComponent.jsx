import React, { Component } from 'react'
import ExcIEEEAC4AService from '../services/ExcIEEEAC4AService'

class ViewExcIEEEAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC4A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC4AService.getExcIEEEAC4AById(this.state.id).then( res => {
            this.setState({excIEEEAC4A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC4A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEAC4A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC4AComponent
