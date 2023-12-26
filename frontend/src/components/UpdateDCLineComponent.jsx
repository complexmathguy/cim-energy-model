import React, { Component } from 'react'
import DCLineService from '../services/DCLineService';

class UpdateDCLineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCLine = this.updateDCLine.bind(this);

    }

    componentDidMount(){
        DCLineService.getDCLineById(this.state.id).then( (res) =>{
            let dCLine = res.data;
            this.setState({
            });
        });
    }

    updateDCLine = (e) => {
        e.preventDefault();
        let dCLine = {
            dCLineId: this.state.id,
        };
        console.log('dCLine => ' + JSON.stringify(dCLine));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCLineService.updateDCLine(dCLine).then( res => {
            this.props.history.push('/dCLines');
        });
    }


    cancel(){
        this.props.history.push('/dCLines');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCLine</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCLine}>Save</button>
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

export default UpdateDCLineComponent
