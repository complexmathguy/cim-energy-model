import React, { Component } from 'react'
import ExcAC8BService from '../services/ExcAC8BService'

class ViewExcAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC8B: {}
        }
    }

    componentDidMount(){
        ExcAC8BService.getExcAC8BById(this.state.id).then( res => {
            this.setState({excAC8B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC8B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> inlim:&emsp; </label>
                            <div> { this.state.excAC8B.inlim }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAC8B.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excAC8B.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excAC8B.kd }</div>
                        </div>
                        <div className = "row">
                            <label> kdr:&emsp; </label>
                            <div> { this.state.excAC8B.kdr }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excAC8B.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kir:&emsp; </label>
                            <div> { this.state.excAC8B.kir }</div>
                        </div>
                        <div className = "row">
                            <label> kpr:&emsp; </label>
                            <div> { this.state.excAC8B.kpr }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excAC8B.ks }</div>
                        </div>
                        <div className = "row">
                            <label> pidlim:&emsp; </label>
                            <div> { this.state.excAC8B.pidlim }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excAC8B.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excAC8B.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excAC8B.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tdr:&emsp; </label>
                            <div> { this.state.excAC8B.tdr }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excAC8B.te }</div>
                        </div>
                        <div className = "row">
                            <label> telim:&emsp; </label>
                            <div> { this.state.excAC8B.telim }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excAC8B.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excAC8B.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vemin:&emsp; </label>
                            <div> { this.state.excAC8B.vemin }</div>
                        </div>
                        <div className = "row">
                            <label> vfemax:&emsp; </label>
                            <div> { this.state.excAC8B.vfemax }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excAC8B.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.excAC8B.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vpidmax:&emsp; </label>
                            <div> { this.state.excAC8B.vpidmax }</div>
                        </div>
                        <div className = "row">
                            <label> vpidmin:&emsp; </label>
                            <div> { this.state.excAC8B.vpidmin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excAC8B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excAC8B.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> vtmult:&emsp; </label>
                            <div> { this.state.excAC8B.vtmult }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC8BComponent
