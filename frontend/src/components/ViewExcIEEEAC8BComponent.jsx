import React, { Component } from 'react'
import ExcIEEEAC8BService from '../services/ExcIEEEAC8BService'

class ViewExcIEEEAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC8B: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC8BService.getExcIEEEAC8BById(this.state.id).then( res => {
            this.setState({excIEEEAC8B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC8B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.kd }</div>
                        </div>
                        <div className = "row">
                            <label> kdr:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.kdr }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kir:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.kir }</div>
                        </div>
                        <div className = "row">
                            <label> kpr:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.kpr }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tdr:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.tdr }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.te }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vemin:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.vemin }</div>
                        </div>
                        <div className = "row">
                            <label> vfemax:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.vfemax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEAC8B.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC8BComponent
