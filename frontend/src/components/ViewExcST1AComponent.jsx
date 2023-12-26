import React, { Component } from 'react'
import ExcST1AService from '../services/ExcST1AService'

class ViewExcST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST1A: {}
        }
    }

    componentDidMount(){
        ExcST1AService.getExcST1AById(this.state.id).then( res => {
            this.setState({excST1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ilr:&emsp; </label>
                            <div> { this.state.excST1A.ilr }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excST1A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excST1A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excST1A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> klr:&emsp; </label>
                            <div> { this.state.excST1A.klr }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excST1A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excST1A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tb1:&emsp; </label>
                            <div> { this.state.excST1A.tb1 }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excST1A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tc1:&emsp; </label>
                            <div> { this.state.excST1A.tc1 }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excST1A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excST1A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excST1A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excST1A.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.excST1A.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excST1A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excST1A.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> xe:&emsp; </label>
                            <div> { this.state.excST1A.xe }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST1AComponent
