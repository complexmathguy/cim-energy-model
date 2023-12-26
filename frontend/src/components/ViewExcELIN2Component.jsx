import React, { Component } from 'react'
import ExcELIN2Service from '../services/ExcELIN2Service'

class ViewExcELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excELIN2: {}
        }
    }

    componentDidMount(){
        ExcELIN2Service.getExcELIN2ById(this.state.id).then( res => {
            this.setState({excELIN2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcELIN2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdbas:&emsp; </label>
                            <div> { this.state.excELIN2.efdbas }</div>
                        </div>
                        <div className = "row">
                            <label> iefmax:&emsp; </label>
                            <div> { this.state.excELIN2.iefmax }</div>
                        </div>
                        <div className = "row">
                            <label> iefmax2:&emsp; </label>
                            <div> { this.state.excELIN2.iefmax2 }</div>
                        </div>
                        <div className = "row">
                            <label> iefmin:&emsp; </label>
                            <div> { this.state.excELIN2.iefmin }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.excELIN2.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k1ec:&emsp; </label>
                            <div> { this.state.excELIN2.k1ec }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.excELIN2.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.excELIN2.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> k4:&emsp; </label>
                            <div> { this.state.excELIN2.k4 }</div>
                        </div>
                        <div className = "row">
                            <label> kd1:&emsp; </label>
                            <div> { this.state.excELIN2.kd1 }</div>
                        </div>
                        <div className = "row">
                            <label> ke2:&emsp; </label>
                            <div> { this.state.excELIN2.ke2 }</div>
                        </div>
                        <div className = "row">
                            <label> ketb:&emsp; </label>
                            <div> { this.state.excELIN2.ketb }</div>
                        </div>
                        <div className = "row">
                            <label> pid1max:&emsp; </label>
                            <div> { this.state.excELIN2.pid1max }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excELIN2.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excELIN2.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> tb1:&emsp; </label>
                            <div> { this.state.excELIN2.tb1 }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excELIN2.te }</div>
                        </div>
                        <div className = "row">
                            <label> te2:&emsp; </label>
                            <div> { this.state.excELIN2.te2 }</div>
                        </div>
                        <div className = "row">
                            <label> ti1:&emsp; </label>
                            <div> { this.state.excELIN2.ti1 }</div>
                        </div>
                        <div className = "row">
                            <label> ti3:&emsp; </label>
                            <div> { this.state.excELIN2.ti3 }</div>
                        </div>
                        <div className = "row">
                            <label> ti4:&emsp; </label>
                            <div> { this.state.excELIN2.ti4 }</div>
                        </div>
                        <div className = "row">
                            <label> tr4:&emsp; </label>
                            <div> { this.state.excELIN2.tr4 }</div>
                        </div>
                        <div className = "row">
                            <label> upmax:&emsp; </label>
                            <div> { this.state.excELIN2.upmax }</div>
                        </div>
                        <div className = "row">
                            <label> upmin:&emsp; </label>
                            <div> { this.state.excELIN2.upmin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excELIN2.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excELIN2.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> xp:&emsp; </label>
                            <div> { this.state.excELIN2.xp }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcELIN2Component
