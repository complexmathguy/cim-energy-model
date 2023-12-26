import React, { Component } from 'react'
import LineService from '../services/LineService';

class UpdateLineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLine = this.updateLine.bind(this);

    }

    componentDidMount(){
        LineService.getLineById(this.state.id).then( (res) =>{
            let line = res.data;
            this.setState({
            });
        });
    }

    updateLine = (e) => {
        e.preventDefault();
        let line = {
            lineId: this.state.id,
        };
        console.log('line => ' + JSON.stringify(line));
        console.log('id => ' + JSON.stringify(this.state.id));
        LineService.updateLine(line).then( res => {
            this.props.history.push('/lines');
        });
    }


    cancel(){
        this.props.history.push('/lines');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Line</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLine}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateLineComponent
