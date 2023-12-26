import React, { Component } from 'react'
import LineService from '../services/LineService'

class ListLineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                lines: []
        }
        this.addLine = this.addLine.bind(this);
        this.editLine = this.editLine.bind(this);
        this.deleteLine = this.deleteLine.bind(this);
    }

    deleteLine(id){
        LineService.deleteLine(id).then( res => {
            this.setState({lines: this.state.lines.filter(line => line.lineId !== id)});
        });
    }
    viewLine(id){
        this.props.history.push(`/view-line/${id}`);
    }
    editLine(id){
        this.props.history.push(`/add-line/${id}`);
    }

    componentDidMount(){
        LineService.getLines().then((res) => {
            this.setState({ lines: res.data});
        });
    }

    addLine(){
        this.props.history.push('/add-line/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Line List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLine}> Add Line</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.lines.map(
                                        line => 
                                        <tr key = {line.lineId}>
                                             <td>
                                                 <button onClick={ () => this.editLine(line.lineId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLine(line.lineId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLine(line.lineId)} className="btn btn-info btn-sm">View </button>
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

export default ListLineComponent
