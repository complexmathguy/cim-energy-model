import React, { Component } from 'react'
import CurveService from '../services/CurveService'

class ListCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                curves: []
        }
        this.addCurve = this.addCurve.bind(this);
        this.editCurve = this.editCurve.bind(this);
        this.deleteCurve = this.deleteCurve.bind(this);
    }

    deleteCurve(id){
        CurveService.deleteCurve(id).then( res => {
            this.setState({curves: this.state.curves.filter(curve => curve.curveId !== id)});
        });
    }
    viewCurve(id){
        this.props.history.push(`/view-curve/${id}`);
    }
    editCurve(id){
        this.props.history.push(`/add-curve/${id}`);
    }

    componentDidMount(){
        CurveService.getCurves().then((res) => {
            this.setState({ curves: res.data});
        });
    }

    addCurve(){
        this.props.history.push('/add-curve/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Curve List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCurve}> Add Curve</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> CurveStyle </th>
                                    <th> XUnit </th>
                                    <th> Y1Unit </th>
                                    <th> Y2Unit </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.curves.map(
                                        curve => 
                                        <tr key = {curve.curveId}>
                                             <td> { curve.curveStyle } </td>
                                             <td> { curve.xUnit } </td>
                                             <td> { curve.y1Unit } </td>
                                             <td> { curve.y2Unit } </td>
                                             <td>
                                                 <button onClick={ () => this.editCurve(curve.curveId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCurve(curve.curveId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCurve(curve.curveId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListCurveComponent
