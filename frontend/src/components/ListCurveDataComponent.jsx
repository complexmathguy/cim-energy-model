import React, { Component } from 'react'
import CurveDataService from '../services/CurveDataService'

class ListCurveDataComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                curveDatas: []
        }
        this.addCurveData = this.addCurveData.bind(this);
        this.editCurveData = this.editCurveData.bind(this);
        this.deleteCurveData = this.deleteCurveData.bind(this);
    }

    deleteCurveData(id){
        CurveDataService.deleteCurveData(id).then( res => {
            this.setState({curveDatas: this.state.curveDatas.filter(curveData => curveData.curveDataId !== id)});
        });
    }
    viewCurveData(id){
        this.props.history.push(`/view-curveData/${id}`);
    }
    editCurveData(id){
        this.props.history.push(`/add-curveData/${id}`);
    }

    componentDidMount(){
        CurveDataService.getCurveDatas().then((res) => {
            this.setState({ curveDatas: res.data});
        });
    }

    addCurveData(){
        this.props.history.push('/add-curveData/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">CurveData List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCurveData}> Add CurveData</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Xvalue </th>
                                    <th> Y1value </th>
                                    <th> Y2value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.curveDatas.map(
                                        curveData => 
                                        <tr key = {curveData.curveDataId}>
                                             <td> { curveData.xvalue } </td>
                                             <td> { curveData.y1value } </td>
                                             <td> { curveData.y2value } </td>
                                             <td>
                                                 <button onClick={ () => this.editCurveData(curveData.curveDataId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCurveData(curveData.curveDataId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCurveData(curveData.curveDataId)} className="btn btn-info btn-sm">View </button>
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

export default ListCurveDataComponent
